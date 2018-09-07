package Bingo.verify.data;

public enum BrowerTypeEnum {
	Chrome(0),FireFox(1);
	private int BrowerType;
	BrowerTypeEnum(int BrowerType){
		this.BrowerType = BrowerType;
	}

	public int getType(){
		return BrowerType;
	}
	
	public static BrowerTypeEnum getBrowerType(int BrowerType) {
		switch(BrowerType){
		case 1 :
			return Chrome;
		case 2 :
			return FireFox;
		default :
			return null;
		}
	}
}
