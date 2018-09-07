package Bingo.verify.data;

public enum DataLoadStatus {
	NEW_CREATED(0),IMPORTING(1),SUCCESS(2),FAILED(3);
	
	private int value;
	DataLoadStatus(int value){
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public static DataLoadStatus valueof(int value) {
		switch (value) {
		case 0:
			return NEW_CREATED;
		case 1:
			return IMPORTING;
		case 2:
			return SUCCESS;
		case 3:
			return FAILED;
		default:
			return null;
		}
	}
}
