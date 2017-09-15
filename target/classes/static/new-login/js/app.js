

$(function() {
  $('#log-form').validator({
    onValid: function(validity) {
      $(validity.field).closest('.am-input-group').find('.am-alert').hide();
    },

    onInValid: function(validity) {
      var $field = $(validity.field);
      var $group = $field.closest('.am-input-group');
      var $alert = $group.find('.am-alert');
      // 使用自定义的提示信息 �? 插件内置的提示信�?
      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

      if (!$alert.length) {
        $alert = $('<div class="log-alert am-alert am-alert-danger am-radius"></div>').hide().
          appendTo($group);
      }

      $alert.html(msg).show();
    }
  });
  
});