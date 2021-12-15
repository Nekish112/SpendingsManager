$(document).ready(function (){
  $('select').formSelect();
  let $name = $('select[name="spendingType"]');
  let $amount = $('input[name="spendingAmount"]');
  let $type = $('select[name="paymentType"]');
  let $date = $('input[name="spendingDate"]');

  let $entity = {}

  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");

  $(document).ajaxSend(function(e, xhr, options) {
    $name = $('select[name="spendingType"]');
    $amount = $('input[name="spendingAmount"]');
    $type = $('select[name="paymentType"]');
    $date = $('input[name="spendingDate"]');

    $entity = {}

    $entity.paymentType = $type;
    $entity.spendingType = $name;
    $entity.date = $date;
    $entity.amount = $amount;

    xhr.setRequestHeader(header, token);
  });

$('#button').click(function e() {
  $.ajax({
    type: "POST",
    url: "/",
    xhrFields: {
      withCredentials: true
    },
    data: JSON.stringify({
      "paymentType": $type.val(),
      "amount": $amount.val(),
      "spendingType": $name.val(),
      "date": $date.val()
    }),
    contentType : 'application/json',
    success: function(result) {
      var type_icon;
      if ($type.val() == 'CARD') {
        type_icon = "<i class='fa fa-credit-card'></i>";
      } else if ($type.val() == 'CASH') {
        type_icon = "<i class='fa fa-money'></i>";
      } else if ($type.val() == 'OTHER') {
        type_icon = "<i class='fa fa-question-circle'></i>";
      }

      $("table tr:first").after('<tr><td>'+type_icon+'</td><td>'+$name.text()+'</td><td>'+$date.val()+'</td><td class="amount">'+$amount.val()+'</td></tr>');
      $date.val(null);
      $amount.val(null);
      $("#if-empty").remove();
    },
    error: function(result) {
      alert('Error at saving new spending');
    }
  });
  });
  
});
