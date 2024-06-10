# Aplicación para consumo de Idiomas iso-639-1

[Idioma](https://juanmedina100.github.io/idiomas-iso-639-1-json/idiomas-639-1.json)

Complemento del [repositorio](https://github.com/juanmedina100/idiomas-iso-639-1-json) de los idiomas.

## Que es el ISO 639-1

ISO 639-1 es la primera parte del código ISO 639. Consiste en 184 códigos de dos letras usados para identificar los principales idiomas del mundo. Estos códigos son una taquigrafía internacional muy útil para indicar idiomas. Por ejemplo:

 - El español está representado por es
 - El inglés está representado por en
 - El alemán está representado por de (del endónimo Deutsch)
 - El japonés está representado por ja (aunque su endónimo es Nihongo)
La lista de códigos ISO 639-1 se convirtió en norma oficial en 2002, aunque ha existido en formato borrador desde hace años. El último código añadido fue ht, representando al criollo haitiano el 26 de febrero de 2003. El uso de la norma fue apoyado por IETF language tags, introducido por RFC 1766 en marzo de 1995, y continuado por RFC 3066 en enero de 2001 y por RFC 4646 en septiembre de 2006.


### Capturas

![](asset/img01.png)
![](asset/img02.png)
![](asset/img03.png)

JSON utilizado
```JSON
{
  "idiomas": [
    {
      "idioma": "Abkhaz",
      "codigo": "ab"
    },
    {
      "idioma": "Afar",
      "codigo": "aa"
    },
    {
      "idioma": "Africanos",
      "codigo": "af"
    },
    {
      "idioma": "Akan",
      "codigo": "ak"
    }
  ]
}
```

DTO Usado
```kotlin
data class IdiomasDto(
    val idiomas: List<Idioma>
)
```

Modelo Idioma
```kotlin
data class Idioma(
    val idioma: String,
    val codigo: String
)
```

