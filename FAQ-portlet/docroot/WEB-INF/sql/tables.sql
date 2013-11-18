create table FAQ_FAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	question VARCHAR(75) null,
	category VARCHAR(75) null,
	answer VARCHAR(75) null,
	isactive BOOLEAN,
	displayOrder LONG
);