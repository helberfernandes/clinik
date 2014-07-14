package br.com.wofsolutions.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




/**
 * Define quais campos nao devem aparecer no webservice
 * Somente que nao possuirem esta anotacao aparecera
 * @author Helber
 * @since 1.0	
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ServiceColumnExclusion {

}
