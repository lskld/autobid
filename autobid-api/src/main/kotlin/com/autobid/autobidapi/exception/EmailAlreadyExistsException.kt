package com.autobid.autobidapi.exception

class EmailAlreadyExistsException(email: String) :
    RuntimeException("Email $email already exists")