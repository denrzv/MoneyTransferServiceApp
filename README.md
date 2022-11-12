# Money Service API

### Документация по сервису

#### Описание

REST сервис для обработки запросов на перевод средств с карты на карту.

#### Эндпоинты:

* /transfer
* /confirmOperation

Запускается на порту 5500/TCP.

Создан в соответствии со [спецификацией](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml).

#### Запуск

Для запуска выполнить:

* docker build -t moneytransferservice .
* docker run moneytransferservice
* проверка работы выполняется через http.request тесты в проекте

#### Проверка
* Запустить Google Chrome без проверки CORS [инструкция](https://alfilatov.com/posts/run-chrome-without-cors/).
* Перейти в [веб-интерфейс](https://serp-ya.github.io/card-transfer/) сервиса перевода средств.
* Указать вымышленные данные карт, в репозиторий предзагружены карты 1111111111111111 и 2222222222222222.
* Выполнить перевод.
* Логирование приложение выполняется в файл log.txt.