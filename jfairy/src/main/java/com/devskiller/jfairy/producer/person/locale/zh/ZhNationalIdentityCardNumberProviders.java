package com.devskiller.jfairy.producer.person.locale.zh;

import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.person.NationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.util.ZhFairyUtil;

import java.time.LocalDate;

public class ZhNationalIdentityCardNumberProviders implements NationalIdentityCardNumberProvider {

	private final Person.Sex sex;
	private final LocalDate date;
	private final BaseProducer baseProducers;
	private static final int TWO_MAX = 99;

	private final String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
	private final String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };


	public ZhNationalIdentityCardNumberProviders(Person.Sex sex, LocalDate date,BaseProducer baseProducers) {
		this.sex = sex;
		this.date = date;
		this.baseProducers = baseProducers;
	}

	@Override
	public String get() {
		StringBuilder idBuilder = new StringBuilder();
		idBuilder.append(baseProducers.randomElement(ZhFairyUtil.PROV_LIST));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, ZhFairyUtil.CITY_MAX, 2));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, ZhFairyUtil.DISTRICT_MAX, 2));
		idBuilder.append(getDateStr(date));
		idBuilder.append(ZhFairyUtil.getRandomNumStr(baseProducers, TWO_MAX, 2));
		idBuilder.append(ZhFairyUtil.getMFRandomNumStr(sex));
		idBuilder.append(ZhFairyUtil.getEndStr(idBuilder.toString()));

		return idBuilder.toString();
	}

	public String getEndStr(String Ai){
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String endCode = ValCodeArr[modValue];
		return endCode;
	}

	public String getDateStr(LocalDate date){
		return "";
	}
}
