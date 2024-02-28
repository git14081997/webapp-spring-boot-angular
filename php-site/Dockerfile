FROM php:8-apache

RUN docker-php-ext-install mysqli && \
	docker-php-ext-enable mysqli

WORKDIR /var/www/html

COPY src/ .

EXPOSE 80
