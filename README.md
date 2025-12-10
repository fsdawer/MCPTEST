# MCPTEST

GitHub MCP 서버 및 자동화 워크플로우 테스트 프로젝트

## 구조

```
demo/
├── frontend/          # Vue.js 프론트엔드
├── mcp-server/        # GitHub MCP 서버
└── .github/
    ├── workflows/     # GitHub Actions
    └── ISSUE_TEMPLATE/  # 이슈 템플릿
```

## 기능

### MCP 서버
- GitHub API 연동 (Repository, Issue, PR, Commit)
- Claude와 연결하여 GitHub 작업 자동화

### GitHub Actions
- **CI**: 빌드/테스트 자동화
- **PR Labeler**: 파일 변경에 따른 자동 라벨링
- **PR Review**: 변경 통계 자동 리포트
- **Auto PR**: develop → main 자동 PR

## 설치

```bash
# MCP 서버
cd mcp-server
npm install
cp config/config.example.json config/config.json
# config.json에 GitHub 토큰 설정

# 프론트엔드
cd frontend
npm install
npm run dev
```

## 라이선스

MIT

---
> 마지막 업데이트: 2025-12-10
