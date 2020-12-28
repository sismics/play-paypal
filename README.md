[![GitHub release](https://img.shields.io/github/release/sismics/play-paypal.svg?style=flat-square)](https://github.com/sismics/play-paypal/releases/latest)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# play-paypal plugin

This plugin adds [Paypal](https://paypal.com//) support to Play! Framework 1 applications.

# Features

# How to use

####  Add the dependency to your `dependencies.yml` file

```
require:
    - paypal -> paypal 1.2.0

repositories:
    - sismicsNexusRaw:
        type: http
        artifact: "https://nexus.sismics.com/repository/sismics/[module]-[revision].zip"
        contains:
            - paypal -> *

```
####  Set configuration parameters

Add the following parameters to **application.conf**:

```
# Paypal configuration
# ~~~~~~~~~~~~~~~~~~~~
paypal.mock=false
paypal.url=https://thirdparty.paypal.eu
paypal.clientId=12345678
```
####  Use the API

```
WebhookService webhookService = PaypalClient.get().getWebhookService();
WebhookData webhookData = webhookService.processWebhook(request.body);
```

####  Mock the Paypal server in dev

We recommand to mock Paypal in development mode and test profile.

Use the following configuration parameter:

```
paypal.mock=true
```

# License

This software is released under the terms of the Apache License, Version 2.0. See `LICENSE` for more
information or see <https://opensource.org/licenses/Apache-2.0>.
