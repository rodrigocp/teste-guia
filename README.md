### Resume
Mock Service

### Database:
* No use of databases and repositories

### Services:
* Simple Mock Service

### Build
* Run Gradle Build (excluding tests):
```
$ gradle clean build -x test
```
* Do a GET Request for Transaction List:
```
$ curl --request GET --url http://localhost:8080/1000/transacoes/2020/07/
```
* Response Look Like:
```
[
  {
    "data": 1594531312744,
    "descricao": "lijeboe jegea civajea madujao nipezocugoo nave cavedaroce mami",
    "valor": 0
  },
  {
    "data": 1596230375531,
    "descricao": "goradigese rodizigasu pubico godejilagu zito sagenogao tuvatanui",
    "valor": -142
  },
  {
    "data": 1596105652724,
    "descricao": "bogafosobeu zolau ripafomia rubegui jivefolamuo vodemosii cubusaso",
    "valor": -284
  },
  {
    "data": 1595277354920,
    "descricao": "legatoe nedafi sinudaa nanui sima refigepaloo sozoluro rubaja",
    "valor": 426
  },
  {
    "data": 1595041919809,
    "descricao": "batagadua lope deludunai zefogamafu cifu sonepa dunudaji tizace",
    "valor": -568
  },
  {
    "data": 1594769444705,
    "descricao": "taririruu tefegipua lelocobumio fovunee ginorasoa tajoo dopemejeo",
    "valor": 710
  },
  {
    "data": 1594455409920,
    "descricao": "tizubu pete seru tolu puta pufofofo madeso matalemu rajacetau",
    "valor": 852
  }
]
```
