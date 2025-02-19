package com.ll.global.jpa.entity;

import com.ll.standard.util.Ut
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    var id: Long? = null

    val modelName: String
        get() = Ut.str.lcfirst(this::class.java.simpleName)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        other as BaseEntity

        if (id == null || other.id == null) return false

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: System.identityHashCode(this)
    }
}