create table FAQ_FAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	question VARCHAR(75) null,
	category VARCHAR(75) null,
	answer VARCHAR(75) null,
	isactive BOOLEAN,
	displayorder LONG,
	categoryOrder LONG
);