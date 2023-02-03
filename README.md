# spring-boot-aop-annotation

### AOP terminology

- <b>Aspect</b> - comprised of PointCut and Advice, mainly use for configure PointCut and Advice (specific action)
- <b>Pointcut</b> - configure which place AOP should cut into, such as class or method
- <b>JoinPoint</b> - the actual point to be cut into, normally is the method
- <b>Advice</b> - the specific actions to be run in JoinPoint

### 4 type of Advices

- Before advice
- After advice
- After returning advice
- After throwing advice
- Around advice

### Order of Advices

1. Around
2. Before
3. Around
4. After
5. AfterReturning
6. AfterThrowing

### Usage example for following AOP annotation

- @Aspect
- @Pointcut
- @Around
- @Before
- @After
- @AfterReturning
- @AfterThrowing

### Defining custom annotation for <i>PointCut</i>

- @AroundTraceable
- @BeforeTraceable
- @AfterTraceable
- @AfterReturningTraceable

### Defining custom <i>Aspect</i> and <i>Advice</i>

- ControllerLoggerAdvice
- AroundTraceableAspect
- BeforeTraceableAspect
- AfterTraceableAspect
- AfterReturningTraceableAspect