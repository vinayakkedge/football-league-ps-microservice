package ke.vk.vinayak.kedge.footballleague.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ke.vk.vinayak.kedge.footballleague.eventtype.LogEventType;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Trace {
  LogEventType type() default LogEventType.SERVICE;
}
