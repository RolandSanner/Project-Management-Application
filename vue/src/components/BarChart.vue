<template>
    <div>
        <canvas id="bar-chart"></canvas>
    </div>
</template>

<script>
import Chart from 'chart.js/auto'
export default {
    name: 'bar-chart',
    mounted() {
        const ctx = document.getElementById('bar-chart')
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ["Baseline Schedule", "Updated Schedule", "Site Progress", "Delay"],
                datasets: [
                    {
                        label: "Work Days",
                        data: [300, 320, 250, 20],
                        backgroundColor: [
                            'rgba(255, 205, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(153, 102, 255, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 205, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(153, 102, 255, 0.2)'
                        ],
                        borderWidth: 3
                    }
                ]
            }
        })
    }
}
</script>

<style>

#bar-chart {
    background-color: white;
}

</style>