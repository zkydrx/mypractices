package test.Enum;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-07-08 Time: 00:47:46
 * Description:
 */
public enum MonthEnum implements SaySomething {
	JANUARY("1", "一月") {
		@Override
		public String say(String word) {
			return JANUARY.getDesc() + word;
		}
	},
	FEBRUARY("2", "二月") {
		@Override
		public String say(String word) {
			return FEBRUARY.getDesc() + word;
		}
	},
	MARCH("3", "三月") {
		@Override
		public String say(String word) {
			return MARCH.getDesc() + word;
		}
	},
	APRIL("4", "四月") {
		@Override
		public String say(String word) {
			return APRIL.getDesc() + word;
		}
	},
	MAY("5", "五月") {
		@Override
		public String say(String word) {
			return MAY.getDesc() + word;
		}
	},
	JUNE("6", "六月") {
		@Override
		public String say(String word) {
			return JUNE.getDesc() + word;
		}
	},
	JULY("7", "七月") {
		@Override
		public String say(String word) {
			return JULY.getDesc() + word;
		}
	},
	AUGUST("8", "八月") {
		@Override
		public String say(String word) {
			return AUGUST.getDesc() + word;
		}
	},
	SEPTEMBER("9", "九月") {
		@Override
		public String say(String word) {
			return SEPTEMBER.getDesc() + word;
		}
	},
	OCTOBER("10", "十月") {
		@Override
		public String say(String word) {
			return OCTOBER.getDesc() + word;
		}
	},
	NOVEMBER("11", "十一月") {
		@Override
		public String say(String word) {
			return NOVEMBER.getDesc() + word;
		}
	},
	DECEMBER("12", "十二月") {
		@Override
		public String say(String word) {
			return DECEMBER.getDesc() + word;
		}
	};
	private String code;
	private String desc;

	MonthEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static MonthEnum getMonthEnum(String code) {
		MonthEnum[] values = MonthEnum.values();

		for (MonthEnum value : values) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}

interface SaySomething {
	String say(String word);
}