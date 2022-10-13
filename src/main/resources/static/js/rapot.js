$(document).ready(function () {
  $("#table-rapot").DataTable({
    ajax: {
      url: "/api/rapot",
      dataSrc: "",
    },
    columns: [
      {
        data: null,
        render: (data, type, row, meta) => {
          return meta.row + 1;
        },
      },
      {
        data: "mataPelajarans.nama",
      },
      {
        data: "nilai",
      },
      {
        data: "mataPelajarans.entitas[0].nama",
      },
      // {
      //   data: null,
      //   render: (data, type, row, meta) => {
      //     return `
      //       <tr th:each = "entitas : ${enti}">
      //       </tr>
      //       `;
      //   },
      // },
      {
        data: null,
        render: (data, type, row, meta) => {
          return `
                          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailRegion" onclick="findById(${data.id})">
                          Detail
                          </button>
  
                          <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateRegion" onclick="beforeUpdate(${data.id})">
                          Update
                          </button>
  
                           <button type="button" class="btn btn-danger" onclick="deleteRegion(${data.id})">
                          Delete
                          </button>
                      `;
        },
      },
    ],
  });
});
