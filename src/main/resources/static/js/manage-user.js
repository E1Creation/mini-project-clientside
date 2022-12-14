$(document).ready(function () {
  $("#table-manage-user").DataTable({
    ajax: {
      url: "/api/entitas",
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
        data: "nama",
      },
      {
        data: "user.username",
      },
      {
        data: "user.isAccountLocked",
      },
      {
        data: "user.isEnabled",
      },
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
