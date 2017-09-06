USE initdb;

#------Добавить разработчику поле salary
ALTER TABLE developers
  ADD dev_salary INT;

#------Вычислить общую ЗП всех разработчиков
SELECT SUM(dev_salary) AS 'Total salary of developers'
FROM developers;

#------Вычислить количество разработчиков по каждому скилу
SELECT
  skills.skill_name,
  count(developers.dev_id) AS 'Total count of developers'
FROM skills
  JOIN dev_skills ON skills.skill_id = dev_skills.skill_id
  JOIN developers ON dev_skills.dev_id = developers.dev_id GROUP BY dev_skills.skill_id;

#------Вычислить все навыки каждого разработчика
SELECT
  developers.dev_id,
  developers.dev_name,
  skill_name
FROM developers
  JOIN dev_skills ON developers.dev_id = dev_skills.dev_id
  JOIN skills ON dev_skills.skill_id = skills.skill_id;

#------Вычислить общую ЗП Java разработчиков
SELECT
  skills.skill_name,
  sum(dev_salary) AS 'Total salary of Java developers'
FROM skills
  JOIN dev_skills ON skills.skill_id = dev_skills.skill_id
  JOIN developers ON dev_skills.dev_id = developers.dev_id WHERE skills.skill_name='Java';


#------Добавить поле (cost - стоимость) в таблицу Projects
ALTER TABLE projects
  ADD project_cost INT;

#------Найти стоимость каждого проекта (исходя из ЗП разработчиков)
SELECT
  projects.project_id,
  projects.project_name,
  SUM(dev_salary)
FROM developers
  JOIN dev_projects ON developers.dev_id = dev_projects.dev_id
  JOIN projects ON projects.project_id = dev_projects.project_id
GROUP BY project_id;

#------Вычислить все проекты, в которых учавствует каждый разработчик
SELECT
  developers.dev_id,
  developers.dev_name,
  projects.project_name
FROM developers
  JOIN dev_projects ON developers.dev_id = dev_projects.dev_id
  JOIN projects ON dev_projects.project_id = projects.project_id;

#------Вычислить количество разработчиков в каждом проекте
SELECT
  projects.project_name,
  count(developers.dev_id) AS 'Total count of developers'
FROM projects
  JOIN dev_projects ON projects.project_id = dev_projects.project_id
  JOIN developers ON dev_projects.dev_id = developers.dev_id GROUP BY projects.project_id;


#------Найти самый дорогой проект (исходя из ЗП разработчиков)
SELECT  max(t.total) AS 'Expensive Project'
FROM
  (SELECT
     projects.project_id ,
     projects.project_name,
     SUM(dev_salary) AS total
   FROM developers
     JOIN dev_projects ON developers.dev_id = dev_projects.dev_id
     JOIN projects ON projects.project_id = dev_projects.project_id
   GROUP BY project_id) AS t;


#------Вычислить количество проектов у каждой компании, отсортировав по company_id
SELECT
  companies.company_id,
  company_name,
  count(projects.company_id)
FROM companies JOIN projects ON companies.company_id = projects.company_id GROUP BY company_name ORDER BY company_id;

#------Вычислить проекты компании EPAM, Luxoft
SELECT
  companies.company_id,
  company_name,
  project_name
FROM companies JOIN projects ON companies.company_id = projects.company_id WHERE company_name IN ('EPAM','Luxoft');

#------Вычислить общее количество сотрудников в каждой компании
SELECT
  companies.company_id,
  company_name,
  COUNT(dev_id) AS 'Developers'
FROM companies
  JOIN developers ON companies.company_id = developers.company_id
GROUP BY developers.company_id;

#------Найти все проекты каждого клиента
SELECT
  customers.customer_id,
  customer_name,
  project_name
FROM customers
  JOIN projects ON customers.customer_id = projects.customer_id;



#------Найти общие затраты каждого клиента на все проекты
SELECT
  customers.customer_id,
  customer_name,
  SUM(project_cost)
FROM customers
  JOIN projects ON customers.customer_id = projects.customer_id GROUP BY projects.customer_id;

