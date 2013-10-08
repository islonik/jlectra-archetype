package com.jlectra.utils.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ANER0310
 *         Date: 2/26/13
 *         Time: 9:47 PM
 */
public class TimestampAdapter extends XmlAdapter<Date, Timestamp> {
	@Override
	public Timestamp unmarshal(Date v) throws Exception {
		return new Timestamp(v.getTime());
	}

	@Override
	public Date marshal(Timestamp v) throws Exception {
		return new Date(v.getTime());
	}
}