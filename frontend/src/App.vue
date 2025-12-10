<script setup>
import { ref } from "vue";
import KakaoMap from "@/components/NaverMap.vue";

const mapRef = ref(null);
const address = ref("");

const findLocation = () => {
  if (mapRef.value && address.value) {
    mapRef.value.searchAddress(address.value);
  }
};
</script>

<template>
  <input
      v-model="address"
      placeholder="예: 서울시 강동구 성내동 123-4"
      style="width: 300px;"
  />
  <button @click="findLocation">검색</button>

  <KakaoMap ref="mapRef"/>
</template>
