//DO NOT MODIFY

package passingAnalytics.tests;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Graded {
	public String description();
	public int marks();
}
