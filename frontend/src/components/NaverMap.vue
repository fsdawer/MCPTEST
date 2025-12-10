<template>
  <div>
    <!-- 주소 입력 -->
    <div style="display: flex; gap: 10px; margin-bottom: 10px;">
      <input v-model="sido" placeholder="시 입력 (예: 서울특별시)" style="width: 150px;" />
      <input v-model="gugun" placeholder="구 입력 (예: 강동구)" style="width: 150px;" />
      <input v-model="dong" placeholder="동 입력 (예: 성내동)" style="width: 150px;" />
      <input v-model="detail" placeholder="상세주소 입력 (예: 123-4)" style="width: 200px;" />
    </div>

    <button @click="searchAddress">검색</button>
    <button @click="registerLocation">등록</button>

    <!-- 지도 -->
    <div id="kakaoMap" style="width: 100%; height: 400px; margin-top: 20px;"></div>
  </div>
</template>


<script setup>
import { ref, onMounted } from "vue";

// 입력값 (이 컴포넌트에서 직접 사용)
const sido = ref("");
const gugun = ref("");
const dong = ref("");
const detail = ref("");

// 지도 관련 변수
const map = ref(null);
const marker = ref(null);
const selectedLat = ref(null);
const selectedLng = ref(null);

onMounted(() => {
  const { kakao } = window;

  map.value = new kakao.maps.Map(
      document.getElementById("kakaoMap"),
      {
        center: new kakao.maps.LatLng(37.5665, 126.9780),
        level: 3
      }
  );
});

const searchAddress = () => {
  const { kakao } = window;
  const geocoder = new kakao.maps.services.Geocoder();
  const ps = new kakao.maps.services.Places();

  // ⛔ props 아님 → ⭕ 로컬 상태 사용해야 함
  const basicAddress = `${sido.value} ${gugun.value} ${dong.value}`;
  const detailAddress = detail.value;

  const fullAddress = `${basicAddress} ${detailAddress}`;

  geocoder.addressSearch(fullAddress, (result, status) => {
    if (status === kakao.maps.services.Status.OK) {
      moveToPosition(result[0].y, result[0].x);
    } else {
      ps.keywordSearch(fullAddress, (data, status2) => {
        if (status2 === kakao.maps.services.Status.OK) {
          moveToPosition(data[0].y, data[0].x);
        } else {
          alert("주소 또는 장소명을 찾을 수 없습니다.");
        }
      });
    }
  });
};

const moveToPosition = (lat, lng) => {
  const { kakao } = window;
  const coords = new kakao.maps.LatLng(lat, lng);

  map.value.setCenter(coords);

  if (marker.value) marker.value.setMap(null);

  marker.value = new kakao.maps.Marker({
    map: map.value,
    position: coords
  });

  selectedLat.value = lat;
  selectedLng.value = lng;
};

defineExpose({
  searchAddress,
  selectedLat,
  selectedLng
});
</script>
