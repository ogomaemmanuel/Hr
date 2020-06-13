<template>
    <div>
        <div class="steps" id="stepsDemo3">
            <!-- Indicator -->
            <div @click.prevent="setStem(0)" :class="{'is-active':step>=0}"
                 class="step-item">
                <div class="step-marker">1</div>
                <div class="step-details">
                    <p class="step-title">Details</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(1)" :class="{'is-active':step>=1}"
                 class="step-item">
                <div class="step-marker">2</div>
                <div class="step-details">
                    <p class="step-title">Set Rules</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(2)" :class="{'is-active':step>=2}"
                 class="step-item">
                <div class="step-marker">3</div>
                <div class="step-details">
                    <p class="step-title">Add Members</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(3)" :class="{'is-active':step>=3}"
                 class="step-item">
                <div class="step-marker">4</div>
                <div class="step-details">
                    <p class="step-title">Finish</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                step: 0
            }
        },
        methods: {
            setStem(step) {

            }
        }
    }
</script>

<style lang="scss" scoped>
    .steps {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        font-size: 1rem;
        min-height: 2rem;
        flex-wrap: nowrap !important;

        .step-item {
            margin-top: 0;
            position: relative;
            -ms-flex-positive: 1;
            flex-grow: 1;
            -ms-flex-preferred-size: 0;
            flex-basis: 0;
            background: #f2f5f9;
            padding-top: 20px;

            .step-details {
                margin-top: 2rem;
                margin-left: .5em;
                margin-right: .5em;
                padding-top: .2em;
                text-align: center;

                .step-title {
                    font-size: 0.9rem;
                    font-weight: 500;
                }
            }

            & .is-active {
                .step-marker {
                    background-color: #fff;
                    border-color: #00d1b2;
                    color: #00d1b2;
                }
            }

            .step-marker {
                height: 2rem;
                width: 2rem;
                position: absolute;
                left: calc(50% - 1rem);
            }

            .step-marker {
                -ms-flex-align: center;
                align-items: center;
                display: -ms-flexbox;
                display: flex;
                border-radius: 50%;
                font-weight: 700;
                -ms-flex-pack: center;
                justify-content: center;
                background: rgb(181, 181, 181);
                color: #fff;
                border: 0.2em solid rgb(255, 255, 255);
                z-index: 1;
            }
        }
    }


</style>