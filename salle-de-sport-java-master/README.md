# Salle de sport

## Besoins

- En tant que commercial, je peux créer de nouvelles formules, au mois ou à l'année, avec les règles suivantes :
  - un prix de base est fixé,
  - auquel on applique 30% de réduction si le client souscrit à un abonnement annuel
- En tant qu'étudiant, j'ai 20% de réduction sur le prix de mon abonnement
- En tant que commercial, je peux voir le chiffre d'affaire en fonction du nombre d'abonnements en cours
- En tant que commercial, je peux voir le chiffre d'affaire en fonction du nombre d'abonnements en cours pour un mois donné
- En tant que client, je reçois un email avec le détail de mon abonnement lorsque je souscris
- En tant que commercial, je peux changer le prix d'une formule
- Un abonnement se renouvelle automatiquement

## Choix

- métier en français => code métier aussi en français, on est en 2018 et Java gère très bien les accents
- utilisation de patterns tactiques du DDD
  - Aggregate
    - [à lire](https://vaughnvernon.co/?p=838)
  - Entity
    - [à lire](http://thepaulrayner.com/blog/aggregates-and-entities-in-domain-driven-design/)
  - Value Object
    - [à lire 1](http://verraes.net/2016/02/type-safety-and-money/)
    - [à lire 2](https://matthiasnoback.nl/2018/03/modelling-quanities-an-exercise-in-designing-value-objects/)
  - Domain Event
    - [à lire](http://verraes.net/2014/11/domain-events/)
  - Repository
- CQRS
- les ids des Aggregate ont leur propres types
  - [à lire](https://buildplease.com/pages/vo-ids/)
- utilisation d'une classe MaDate pour masquer l'implem choisie (`LocalDate`) et centraliser le formattage
  - [explication](https://matthiasnoback.nl/2018/02/mocking-at-architectural-boundaries-persistence-and-time/)
- toutes les classes sont `final` par défaut
  - [explication](https://ocramius.github.io/blog/when-to-declare-classes-final/)
- pas de préfixes get/set
  - [explication](https://blog.pragmatists.com/refactoring-from-anemic-model-to-ddd-880d3dd3d45f)
- les messages des exceptions sont centralisés dans les exceptions
  - [explication](http://rosstuck.com/formatting-exception-messages)
- named constructors
  - [à lire](http://verraes.net/2014/06/named-constructors-in-php/)

## Liens

- [Prez d'Arnaud Lemaire "DDD & CQRS"](https://www.youtube.com/watch?v=qBLtZN3p3FU)
- [slides](https://speakerdeck.com/lilobase/ddd-and-cqrs-php-tour-2018)
