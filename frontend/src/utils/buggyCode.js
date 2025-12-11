// 일부러 오류가 있는 코드 (ESLint 테스트용)

// 오류 1: 사용하지 않는 변수
const unusedVariable = 'hello';
const anotherUnused = 42;

// 오류 2: 정의되지 않은 변수 사용
console.log(undefinedVariable);
console.log(anotherUndefined);

// 오류 3: debugger 문
debugger;

// 오류 4: == 대신 === 사용해야 함
const x = 5;
if (x == '5') {
  console.log('loose equality bad');
}

export function buggyFunction() {
  // 오류 5: 함수 내 사용하지 않는 변수
  const unused = 123;
  const alsoUnused = 'test';

  // 오류 6: 불필요한 세미콜론
  const result = 'bugs';;

  return 'This code has bugs!';
}

// 오류 7: var 사용 (let/const 권장)
var oldStyleVar = 'should use let or const';
