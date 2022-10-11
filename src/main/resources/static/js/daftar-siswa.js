$.ajax({
    url:"https://pokeapi.co/api/v2/pokemon"
}).done((result)=>{
    console.log(result);
    test = "";
    $.each(result.results, function(key,val){
        test += `<tr>
                    <td>${key+1}</td>
                    <td class="cap">${val.name}</td>
                    <td><button class="btn btn-primary" onclick="nama-siswa('${val.url}')" data-bs-toggle="modal" data-bs-target="#modalDetailSW">See Character</button></td>
                </tr>`;
    })
    $("#tbodySW").html(test);
}).fail((error)=>{
    console.log(error);
})