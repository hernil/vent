package com.hernil.vent.application.utils

import org.apache.log4j.Logger
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject


fun <R : Any> R.logger(): Lazy<Logger> {
    return lazy { Logger.getLogger(unwrapCompanionClass(this.javaClass).name) }
}

// unwrap companion class to enclosing class given a Java Class
fun <T: Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass) {
        ofClass.enclosingClass
    } else {
        ofClass
    }
}

// unwrap companion class to enclosing class given a Kotlin Class
fun <T: Any> unwrapCompanionClass(ofClass: KClass<T>): KClass<*> {
    return unwrapCompanionClass(ofClass.java).kotlin
}