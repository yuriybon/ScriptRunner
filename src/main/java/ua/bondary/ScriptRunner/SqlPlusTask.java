package ua.bondary.ScriptRunner;

public class SqlPlusTask extends Task {
	
	//private String script;
	private String preSql = null;
	private String postSql = null;

//	public SqlPlusTask(String userName, String scriptName) {
//		this.taskName  = userName+"@"+scriptName;
//		this.command = "sqlplus -s "+userName+" @"+scriptName;
//	}
	
	
	public SqlPlusTask(String... args) {
		this.taskName  = args[0]+"@"+args[1];
		//this.command = "sqlplus -s "+args[0]+" @"+args[1];
		this.command = args[1];
		if (args.length > 2 )
			this.preSql  = args[2];
		if (args.length > 3 )
			this.postSql  = args[3];
	}

	@Override
	public boolean checkPreCondition() {
		if (preSql != null)
			return true;
		else
			return super.checkPreCondition();
	}

	@Override
	public boolean checkPostCondition() {
		if (postSql != null)
			return true;
		else
			return super.checkPostCondition();
	}

	
}
