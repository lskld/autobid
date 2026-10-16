package com.autobid.autobidapi.exception

class UserNotFoundException(id: Long) : RuntimeException("User $id not found")