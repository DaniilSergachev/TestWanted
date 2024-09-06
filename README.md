Написать запрос в SQL
Есть 2 таблицы
Первая - люди (хранятся персональные данные сотрудников и их родственников) - HPPersonGeneric
  столбцы
[sysId]
,[personId]
,[sysVersion]
,[photoFkSysId]
,[sysExtension]
,[salutation]
,[familyName]
,[givenName]
,[middleName]
,[name]
,[nameTranslationSysId]
,[altFamilyName]
,[altGivenName]
,[altMiddleName]
,[birthDate]
,[gender]
,[maritalStatus]
,[primaryLanguage]
,[citizenship]
,[residence]
,[ethnicity]
,[religion]
,[sysTenant]
,[createdBy]
,[creationTime]
,[sysChangeUser]
,[sysChangeTime]
,[sysParentId]
,[sysDateTo]
,[sysDateFrom] 
Вторая - Родственные связи - HPPersonDependant
столбцы
 [sysId]
,[sysVersion]
 ,[HPPersonGenericSysId]
 ,[HPRelatedPersonSysId]
 ,[attachmentFkSysId]
      ,[sysExtension]
      ,[contactRelationship]
      ,[id]
      ,[sysTenant]
      ,[createdBy]
      ,[creationTime]
      ,[sysChangeUser]
      ,[sysChangeTime]
      ,[sysParentId]
      ,[sysDateTo]
      ,[sysDateFrom]  
Где:
HPPersonGenericSysId- sysId сотрудника
HPRelatedPersonSysId - sysId родственника
contactRelationship- родственная связь
Задача написать запрос который выведет всех родственников (ФИО, дата рождение и родственнная связь) для сотрудника с personId ='test'

РЕШЕНИЕ:



SELECT 
    CONCAT(pg.familyName, ' ', pg.givenName, ' ', pg.middleName) AS "ФИО",
    pg.birthDate AS "Дата рождения",
    pd.contactRelationship AS "Родственная связь"
FROM 
    HPPersonGeneric pg
INNER JOIN 
    HPPersonDependant pd ON pg.sysId = pd.HPRelatedPersonSysId
WHERE 
    pd.HPPersonGenericSysId = (
        SELECT sysId 
        FROM HPPersonGeneric
        WHERE personId = 'test'
    );
