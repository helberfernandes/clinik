package br.com.wofsolutions.util;

import java.util.Calendar;
import java.util.Date;

public class DiaUtil  extends Date {  
/**
	 * 
	 */
	private static final long serialVersionUID = 5914781225312777227L;
	// ___________________________________________________  
    public DiaUtil() {  
        this(System.currentTimeMillis());  
    }  
// ___________________________________________________  
    public DiaUtil(long date) {  
        setTime(date);  
    }  
// ___________________________________________________  
    public DiaUtil(Date date) {  
        this(date.getTime());  
    }  
// ___________________________________________________  
    public void setTime(long time) {  
        super.setTime(time);  
        if(!isDiaUtil(this))  
            setTime(proximoDiaUtil().getTime());  
    }  
// ___________________________________________________  
    public static boolean isDiaUtil(Calendar cal) {  
        return !((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY));  
    }  
// ___________________________________________________  
    public static boolean isDiaUtil(Date dia) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(dia);  
        return isDiaUtil(cal);  
    }  
// ___________________________________________________  
    
    
    
    public static boolean isPrimeiroDiaUtil() {  
    	Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Calendar cal2 = Calendar.getInstance();    
        return cal.getTime().equals(cal2.getTime());  
    }  
    
    public DiaUtil proximoDiaUtil() {  
        return proximoDiaUtil(1);  
    }  
// ___________________________________________________  
    public DiaUtil proximoDiaUtil(int nDias) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(this);  
        for(int i = 0; i < nDias; i++) {  
            while(!isDiaUtil(cal))  
                cal.add(Calendar.DAY_OF_MONTH, 1);  
        }  
        return new DiaUtil(cal.getTime());  
    }  
}  