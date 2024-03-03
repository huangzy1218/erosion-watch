import { faker } from "@faker-js/faker";
import { defineFakeRoute } from "vite-plugin-fake-server/client";

export default defineFakeRoute([
  {
    url: "/my-data/index",
    method: "post",
    response: ({ body }) => {
      let fileList = Array.from({ length: 10 }, (_, index) => {
        const fileType = faker.system.commonFileExt(); // 先生成文件类型
        const fileName = "test".concat(".").concat(fileType); // 根据文件类型生成文件名
        const fileSize = faker.datatype.number({ min: 1000, max: 1000000 }); // 文件大小，单位为字节
        const createDate = faker.date.past().getTime();
        const modifyDate = faker.date.recent().getTime();
        const dept = {
          id: faker.datatype.number({ min: 100, max: 105 }),
          name: faker.commerce.department()
        };

        // 转换文件大小为更可读的格式
        let readableSize;
        if (fileSize < 1024) {
          readableSize = fileSize + " B";
        } else if (fileSize < 1024 * 1024) {
          readableSize = (fileSize / 1024).toFixed(2) + " KB";
        } else {
          readableSize = (fileSize / (1024 * 1024)).toFixed(2) + " MB";
        }

        return {
          id: index + 1,
          fileName,
          fileType,
          fileSize,
          readableSize, // 添加一个新属性来存储可读的文件大小
          createDate,
          modifyDate,
          dept
        };
      });

      // 根据请求体中的条件来过滤数据
      if (body.fileName) {
        fileList = fileList.filter(item =>
          item.fileName.includes(body.fileName)
        );
      }
      if (body.fileType) {
        fileList = fileList.filter(item => item.fileType === body.fileType);
      }
      if (body.deptId) {
        fileList = fileList.filter(item => item.dept.id === body.deptId);
      }

      return {
        success: true,
        data: {
          list: fileList,
          total: fileList.length,
          pageSize: fileList.length, // 返回所有条目
          currentPage: 1
        }
      };
    }
  }
]);
