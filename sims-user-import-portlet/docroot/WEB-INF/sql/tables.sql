create table sims_UserImportLog (
	entryId LONG not null primary key,
	startTime DATE null,
	endTime DATE null,
	totalProcess LONG,
	totalImport LONG,
	totalError LONG,
	summary VARCHAR(75) null,
	createDate DATE null,
	totalExisting LONG
);