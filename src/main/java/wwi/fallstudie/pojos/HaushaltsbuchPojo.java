package wwi.fallstudie.pojos;

public class HaushaltsbuchPojo {
	private int buchId;
	private int userId;

	/**
	 * 
	 */
	 HaushaltsbuchPojo(int buchId, int userId) {
		this.buchId = buchId;
		this.userId = userId;
	}

	/**
	 * @return the buchId
	 */
	int getBuchId() {
		return buchId;
	}

	/**
	 * @param buchId the buchId to set
	 */
	 void setBuchId(int buchId) {
		this.buchId = buchId;
	}

	/**
	 * @return the userId
	 */
	 int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	 void setUserId(int userId) {
		this.userId = userId;
	}

}
