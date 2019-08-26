employeeINSERT INTO `customerdb`.`employee`
(`id`,
`created_on`,
`first_name`,
`last_name`,
`password`,
`updated_at`,
`username`)
VALUES
(<{id: }>,
<{created_on: }>,
<{first_name: }>,
<{last_name: }>,
<{password: }>,
<{updated_at: }>,
<{username: }>);
SELECT * FROM customerdb.customer;

INSERT INTO `customerdb`.`employee`
(`id`,
`created_on`,
`first_name`,
`last_name`,
`password`,
`updated_at`,
`username`,`email_Id`)
VALUES
(2,
NOW(),
'test_first2',
'test_last2',
'test2',
NOW(),
'test', 'test@gmail.com');
