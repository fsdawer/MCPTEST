// 일부러 오류가 있는 코드 (ESLint 테스트용)

// 오류 1: 사용하지 않는 변수
const unusedVariable = 'hello';

// 오류 2: 정의되지 않은 변수 사용
console.log(undefinedVariable);

// 오류 3: debugger 문
debugger;

export function buggyFunction() {
  // 오류 4: 함수 내 사용하지 않는 변수
  const unused = 123;

  return 'This code has bugs!';
}
