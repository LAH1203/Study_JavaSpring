- **1. REST 구성**

  REST API는 다음과 같은 3가지 부분으로 구성됩니다.

   

  **- 자원(Resource) : 자원은 Data, Meta Data, HATEOAS로 나뉩니다.**

  **- 행위(Verb) : HTTP Method로 표현됩니다.**

  **- 표현(Representations)**

   

   

  **2. REST의 특징**

   

  **1) Uniform Interface(유니폼 인터페이스)**

  구성 요소(클라이언트, 서버 등) 사이의 인터페이스는 균일(uniform)해야합니다.

  인터페이스를 일반화함으로써, 전체 시스템 아키텍처가 단순해지고, 상호 작용의 가시성이 개선되며, 

  구현과 서비스가 분리되므로 독립적인 진화가 가능해질 수 있습니다.

   

  **2) Stateless (무상태성)**

  클라이언트와 서버의 통신에는 상태가 없어야합니다. 모든 요청은 필요한 모든 정보를 담고 있어야합니다.

  요청 하나만 봐도 바로 뭔지 알 수 있으므로 가시성이 개선되고, task 실패시 복원이 쉬우므로 신뢰성이 개선되며,

  상태를 저장할 필요가 없으므로 규모 확장성이 개선될 수 있습니다.

  

  **3) Cacheable (캐시 가능)**

  캐시가 가능해야합니다. 즉, 모든 서버 응답은 캐시가 가능한지 그렇지 아닌지 알 수 있어야합니다. 

  효율, 규모 확장성, 사용자 입장에서의 성능이 개선됩니다.

  

  **4) Self-descriptiveness (자체 표현 구조)**

  REST의 또 다른 큰 특징 중 하나는 REST API 메시지만 보고도 이를 쉽게 이해 할 수 있는 

  자체 표현 구조로 되어 있다는 것입니다.

  

  **5) Client - Server 구조**

  클라이언트-서버 스타일은 사용자 인터페이스에 대한 관심(concern)을 데이터 저장에 대한 관심으로부터 분리함으로써

  클라이언트의 이식성과 서버의 규모확장성을 개선할 수 있습니다.

  

  **6) Layered System(계층형 구조)**

  REST 서버는 다중 계층으로 구성될 수 있으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고

  PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 합니다.

   

   

   

  **3. REST API 설계 가이드**

  REST API 설계 시 가장 중요한 항목은 다음과 같습니다.

  

  **1) URI는 정보의 자원을 표현해야 합니다.**

  resource는 동사보다는 명사를, 대문자보다는 소문자를 사용한다.

  resource의 도큐먼트 이름으로는 단수 명사를 사용해야 한다.

  resource의 컬렉션 이름으로는 복수 명사를 사용해야 한다.

  resource의 스토어 이름으로는 복수 명사를 사용해야 한다.

  예 : GET /members/1

   

  **2) 자원에 대한 행위는 HTTP Method (GET, POST, PUT, DELETE)로 표현합니다.**

  

  **3) URI에 HTTP Method가 들어가면 안됩니다.**

  예) GET /books/delete/1 -> DELETE /books/1

  

  **4) URI에 행위에 대한 동사 표현이 들어가면 안됩니다.**

  (즉, CRUD 기능을 나타내는 것은 URI에 사용하지 않습니다.)

  예) GET /books/show/1 -> GET /books/1

  예) GET /books/insert/2 -> POST /books/2

  

  **5) 경로 부분 중 변하는 부분은 유일한 값으로 대체합니다.**

  (즉, id는 하나의 특정 resource를 나타내는 고유값을 의미합니다.)

  예) book을 생성하는 URI: POST /students

  예) id=10 인 book을 삭제하는 URI: DELETE /students/10

  

  **6) 슬래시 구분자(/ )는 계층 관계를 나타내는데 사용합니다.**

  예) http://edwith.org/courses/java

  

  **7) URI 마지막 문자로 슬래시(/ )를 포함하지 않습니다.**

  예) http://edwith.org/courses/ (X)

  

  **8) URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며** 

  **URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 합니다.**

   

  **9) 하이픈(- )은 URI 가독성을 높이는데 사용할 수 있습니다.**

   

  **10) 밑줄( _ )은 URI에 사용하지 않습니다.**

   

  **11) URI 경로에는 소문자가 적합합니다.**

  URI 경로에 대문자 사용은 피하도록 합니다. RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는

  대소문자를 구별하도록 규정하기 때문입니다.

   

  **12) 파일 확장자는 URI에 포함하지 않습니다. Accept header를 사용하도록 합니다.**

  예) http://edwith.org/files/java.jpg (X)

  예) GET /files/jdk18.exe HTTP/1.1 Host: edwith.org Accept: image/jpg (O)

  

  **13) 리소스 간에 연관 관계가 있는 경우 다음과 같은 방법으로 표현합니다.**

  /리소스명/리소스 ID/관계가 있는 다른 리소스명

  예) GET : /books/{bookid}/viewers (일반적으로 소유 ‘has’의 관계를 표현할 때)

  

  **14) 자원을 표현하는 컬렉션(Collection)과 도큐먼트(Document)**

  컬렉션은 객체의 집합, 도큐먼트는 객체라고 생각하면 됩니다. 컬렉션과 도큐먼트 모두 리소스로 표현할 수 있으며 URI로 표현할 수 있습니다.

  예) http://edwith.org/courses/1 

  courses는 컬렉션을 나타냅니다. 복수로 표현해야 합니다. courses/1 은 courses중에서 id가 1인 도큐먼트를 의미합니다.

   

   

  **4. HTTP 응답 상태 코드**

  잘 설계된 REST API는 URI만 잘 설계되는 것이 아니라 그 리소스에 대한 응답도 잘 표현되야 합니다. 

  정확한 응답의 상태 코드만으로도 많은 정보를 전달할 수 있기 때문입니다. 

  자주 사용되는 HTTP 상태 코드는 다음과 같습니다. 

  [![img](https://cphinf.pstatic.net/mooc/20200211_238/1581404548337vItVO_PNG/_.png?type=w760)](https://www.boostcourse.org/web326/lecture/58986?isDesc=false#)