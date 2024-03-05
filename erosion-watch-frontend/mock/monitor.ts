import { defineFakeRoute } from "vite-plugin-fake-server/client";
import { faker } from "@faker-js/faker/locale/zh_CN";

export default defineFakeRoute([
  // 用户管理
  {
    url: "/land-info/list",
    method: "post",
    response: ({ body }) => {
      let list = [
        {
          "id": 1,
          "areaName": "北京市",
          "administrativeCode": "110000",
          "latitude": 39.9042,
          "longitude": 116.4074,
          "area": 16410.54,
          "population": 21540000,
          "climateType": "温带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "山地",
          "landUse": "城市用地"
        },
        {
          "id": 2,
          "areaName": "上海市",
          "administrativeCode": "310000",
          "latitude": 31.2304,
          "longitude": 121.4737,
          "area": 6340.5,
          "population": 24240000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "丘陵",
          "landUse": "工业用地"
        },
        {
          "id": 3,
          "areaName": "广州市",
          "administrativeCode": "440100",
          "latitude": 23.1291,
          "longitude": 113.2644,
          "area": 7434.4,
          "population": 13800000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "水网",
          "landUse": "农业用地"
        },
        {
          "id": 4,
          "areaName": "深圳市",
          "administrativeCode": "440300",
          "latitude": 22.5428,
          "longitude": 114.0596,
          "area": 1997.47,
          "population": 12500000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "丘陵",
          "landformFeature": "平原",
          "landUse": "商业用地"
        },
        {
          "id": 5,
          "areaName": "成都市",
          "administrativeCode": "510100",
          "latitude": 30.5728,
          "longitude": 104.0668,
          "area": 14312.41,
          "population": 16300000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "山地",
          "landUse": "居住用地"
        },
        {
          "id": 6,
          "areaName": "西安市",
          "administrativeCode": "610100",
          "latitude": 34.3416,
          "longitude": 108.9398,
          "area": 10908.1,
          "population": 8700000,
          "climateType": "温带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "高原",
          "landUse": "历史遗址"
        },
        {
          "id": 7,
          "areaName": "杭州市",
          "administrativeCode": "330100",
          "latitude": 30.2741,
          "longitude": 120.1551,
          "area": 16596.21,
          "population": 9200000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "平原",
          "landformFeature": "湖泊",
          "landUse": "旅游用地"
        },
        {
          "id": 8,
          "areaName": "重庆市",
          "administrativeCode": "500000",
          "latitude": 29.5639,
          "longitude": 106.5516,
          "area": 82403,
          "population": 30750000,
          "climateType": "亚热带季风气候",
          "terrainFeature": "山地",
          "landformFeature": "峡谷",
          "landUse": "居住用地"
        }
      ];
      // list = list.filter(item => item.username.includes(body?.username));
      // list = list.filter(item =>
      //   String(item.status).includes(String(body?.status))
      // );
      // if (body.phone) list = list.filter(item => item.phone === body.phone);
      // if (body.deptId) list = list.filter(item => item.dept.id === body.deptId);
      return {
        success: true,
        data: {
          list,
          total: list.length, // 总条目数
          pageSize: 10, // 每页显示条目个数
          currentPage: 1 // 当前页数
        }
      };
    }
  }]);
