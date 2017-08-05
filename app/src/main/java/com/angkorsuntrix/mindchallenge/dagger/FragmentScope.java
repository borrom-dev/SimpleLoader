package com.angkorsuntrix.mindchallenge.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by borrom on 5/8/17.
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}