// 完整版菜单比较多，将 rank 抽离出来，在此方便维护

const home = 0, // 平台规定只有 home 路由的 rank 才能为 0 ，所以后端在返回 rank 的时候需要从非 0 开始
  components = 21,
  able = 22,
  table = 23,
  list = 24,
  result = 25,
  error = 26,
  frame = 7,
  nested = 8,
  permission = 9,
  system = 10,
  tabs = 11,
  editor = 13,
  flowchart = 14,
  formdesign = 15,
  board = 16,
  ppt = 17,
  guide = 18,
  menuoverflow = 19,
  mydata = 1,
  dataanalysis = 3,
  references = 4,
  notes = 5,
  about = 6;

export {
  home,
  components,
  able,
  table,
  list,
  result,
  error,
  frame,
  nested,
  permission,
  system,
  tabs,
  about,
  editor,
  flowchart,
  formdesign,
  board,
  ppt,
  guide,
  menuoverflow,
  mydata,
  dataanalysis,
  references,
  notes
};
