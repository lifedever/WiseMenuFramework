<#import "tags.ftl" as tags>
<@tags.layout.main>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-4">
            <div class="widget style1 navy-bg">
                <div class="row">
                    <div class="col-xs-4">
                        <i class="fa fa-cloud fa-5x"></i>
                    </div>
                    <div class="col-xs-8 text-right">
                        <span> Today degrees </span>
                        <h2 class="font-bold">26'C</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="widget style1 lazur-bg">
                <div class="row">
                    <div class="col-xs-4">
                        <i class="fa fa-envelope-o fa-5x"></i>
                    </div>
                    <div class="col-xs-8 text-right">
                        <span> New messages </span>
                        <h2 class="font-bold">260</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="widget style1 yellow-bg">
                <div class="row">
                    <div class="col-xs-4">
                        <i class="fa fa-music fa-5x"></i>
                    </div>
                    <div class="col-xs-8 text-right">
                        <span> New albums </span>
                        <h2 class="font-bold">12</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="widget navy-bg no-padding">
                <div class="p-m">
                    <h1 class="m-xs">$ 1,540</h1>

                    <h3 class="font-bold no-margins">
                        Annual income
                    </h3>
                    <small>Income form project Alpha.</small>
                </div>
                <div class="flot-chart">
                    <div class="flot-chart-content" id="flot-chart1" style="padding: 0px; position: relative;"><canvas class="flot-base" width="525" height="100" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 525px; height: 100px;"></canvas><canvas class="flot-overlay" width="525" height="100" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 525px; height: 100px;"></canvas></div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="widget lazur-bg no-padding">
                <div class="p-m">
                    <h1 class="m-xs">$ 210,660</h1>

                    <h3 class="font-bold no-margins">
                        Monthly income
                    </h3>
                    <small>Income form project Beta.</small>
                </div>
                <div class="flot-chart">
                    <div class="flot-chart-content" id="flot-chart2" style="padding: 0px; position: relative;"><canvas class="flot-base" width="247" height="100" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 247px; height: 100px;"></canvas><canvas class="flot-overlay" width="247" height="100" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 247px; height: 100px;"></canvas></div>
                </div>
            </div>
        </div>
    </div>
</div>
</@tags.layout.main>
