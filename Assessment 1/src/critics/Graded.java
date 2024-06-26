//DO NOT MODIFY

package critics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Graded {
	String description();
	int marks();
}
