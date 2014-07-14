package br.com.wofsolutions.annotation;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ServiceExclusionStrategy implements ExclusionStrategy {
	    private Class<?> typeToSkip=null;

	    public ServiceExclusionStrategy(Class<?> typeToSkip) {
	      this.typeToSkip = typeToSkip;
	    }

	    public ServiceExclusionStrategy() {
			// TODO Auto-generated constructor stub
		}

		public boolean shouldSkipClass(Class<?> clazz) {
	      return (clazz == typeToSkip);
	    }

	    public boolean shouldSkipField(FieldAttributes f) {
	      return f.getAnnotation(ServiceColumnExclusion.class) != null;
	    }
}