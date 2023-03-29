package service;

public class SelectAny {
	private String nameOrId;
	
	public void setNameOrId(String nameOrId) {
		this.nameOrId = nameOrId;
	}
	
	public boolean select(String text) {
		//使用正则表达式，nameOrId是容器中的数据
		    String regex=".*"+text+".*"; // 正则表达式
		    if(nameOrId.matches(regex)){
		    	System.out.println("匹配成功");
		       return true;
		}
		return false;
	}
	
	//测试
//	public static void main(String args[]) {
//		SelectAny selectAny = new SelectAny();
//		selectAny.setNameOrId("罗振玺");
//		System.out.print(selectAny.select("罗"));
//	}
}
