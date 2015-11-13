<#import "../tags.ftl" as tags>
<#macro show>
<div class="footer">
    <div class="pull-right">
        10GB of <strong>250GB</strong> Free.
    </div>
    <div>
        <strong>Copyright</strong> Example Company &copy; 2014-2015
    </div>
</div>
</div>
</div>
<div id="globalModal" class="modal fade"></div>
<@tags.static.js />
<script>
    var showProfileModal = function(){
        $.get('/account/additional/${Session['session_key_restaurant'].id}', function(data){
            $('#globalModal').html(data).modal('show')
        });
    };

    var hasActive = '${Session['session_key_restaurant'].name!}';
    if(hasActive == ''){
        showProfileModal();
    }

    $('#profileName').on('click', function () {
        showProfileModal();
    });
</script>
</body>
</html>
</#macro>