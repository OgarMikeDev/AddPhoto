//upload photo
$("#load_photo").change(function() {
   if (this.files && this.files[0]) {
      var reader = new FileReader();
      reader.onload = function(e) {
         var img = document.getElementById("img");
         img.src = e.target.result;
         img.style.width="150px";
         img.style.height="150px";
         img.style.borderRadius="150px";
         img.style.border="2px solid black";
         img.style.objectFit="cover";

         var text_form_photo = document.getElementById("text_form_photo");
      }
      reader.readAsDataURL(this.files[0]);
   }
});


//document.getElementById("button_save_photo").addEventListener("click", squareWasClicked, false);

document.getElementById("button_save_photo").onclick = function click() {
    console.log('Test')
    var input = document.querySelector('input[type="file"]')

    var data = new FormData()
    data.append('file', input.files[0])
    console.log(input.files[0])
    fetch('/upload', {
      method: 'POST',
      body: data
    })
};

//Full update data
//$("#button_save_photo").click(function() {
//   var data = $("#form_form_photo").serialize();
//   $.ajax ({
//      method: "POST",
//      url: "/addPhoto/",
//      data: data,
//      success: function(response) {
//         var photo = {};
//         photo[[0]["photo"]] = photo[0]["value"];
//         document.getElementById("text_form_photo").value = document.getElementById("img").src;
//         console.log("Method treatment photo. One element form with data '" + photo[[0]["photo"]] +
//         "'.")
//      }
//   });
//   return false;
//});