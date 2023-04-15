<template>
    <div class="calendar-container">
        <div class="card date-container inset">
            <vue-button class="flex-center calendar-button" @click="prevDay">
                <chevron-ico class="no-select" />
            </vue-button>

            <span class="date-label">{{ `${currMonth + 1}/${currDay}/${currYear}` }}</span>

            <vue-button class="flex-center calendar-button" @click="openCalendar">
                <calendar-ico/>
            </vue-button>

            <vue-button class="flex-center calendar-button" @click="nextDay">
                <chevron-ico :rotationDegree=180 />
            </vue-button>
        </div>
        <transition name="fade">
            <div v-if="calendarVisible" class="calendar-wrap no-select">
                <div class="header">
                    <vue-button class="calendar-button" @click="gotoPresentDate">
                        <home-ico class="home-ico" />
                    </vue-button>

                    <vue-button class="flex-center calendar-button" @click="prevMonth">
                        <chevron-ico />
                    </vue-button>

                    <span class="header-date bold">{{ monthName }} {{ currYear }}</span>

                    <vue-button class="flex-center calendar-button" @click="nextMonth">
                        <chevron-ico :rotationDegree=180 />
                    </vue-button>

                    <vue-button class="calendar-button" @click="deselectDate">
                        <close-ico class="calendar-close" />
                    </vue-button>
                </div>

                <div class="days">
                    <span v-for="(day, index) in days" :key="index" class="day bold">{{ day }}</span>
                </div>
                <div class="dates">
                    <div class="date-wrap flex-center" v-for="(date, index) in dates" :key="index">
                        <div class="date flex-center neu" :class="{
                            // 'curr-date': isCurrDate(currYear, currMonth, date),
                            'inset': isPickedDate(currYear, currMonth, date)
                        }">
                            <span class="bold">{{ date }}</span>
                        </div>
                    </div>
                </div>
            </div>
        </transition>
    </div>
</template>

<script>
export default {
    name: 'vueCalendar',
    data() {
        return {
            months: [
                'Jan', 'Feb', 'Mar',
                'Apr', 'May', 'Jun', 'Jul',
                'Aug', 'Sep', 'Oct',
                'Nov', 'Dec'
            ],
            days: [
                'Mon', 'Tue', 'Wed', 'Thu',
                'Fri', 'Sat', 'Sun'
            ],
            date: new Date(),
            calendarVisible: false,
        }
    },
    computed: {
        currDay() {
            return this.date.getDate()
        },
        currMonth() {
            return this.date.getMonth()
        },
        currYear() {
            return this.date.getFullYear()
        },
        monthName() {
            return this.months[this.date.getMonth()]

        },
        dates() {
            const dates = []
            const offset = this.getOffset(this.currYear, this.currMonth)
            for (let i = 1; i <= offset; i++)
                dates.push('')
            for (let i = 1; i <= new Date(this.date.getFullYear(), this.date.getMonth() + 1, 0).getDate(); i++)
                dates.push(i)
            return dates
        }
    },
    methods: {
        openCalendar() {
            this.calendarVisible = true
        },
        closeCalendar() {
            this.calendarVisible = false
        },
        gotoPresentDate() {
            this.date = new Date()
        },
        prevDay() {
            this.date = new Date(this.date.setDate(this.date.getDate() - 1))
        },
        nextDay() {
            this.date = new Date(this.date.setDate(this.date.getDate() + 1))
        },
        prevMonth() {
            this.date = new Date(this.date.setMonth(this.date.getMonth() - 1))
        },
        nextMonth() {
            this.date = new Date(this.date.setMonth(this.date.getMonth() + 1))
        },
        getOffset(year, month) {
            return (new Date(year, month, 1).getDay() + 6) % 7
        },
        // isCurrDate(year, month, date) {
        //     const currDate = new Date()
        //     return currDate.getFullYear() == year
        //         && currDate.getMonth() == month
        //         && currDate.getDate() == date
        // },
        isPickedDate(year, month, date) {
            return this.date.getFullYear() == year
                && this.date.getMonth() == month
                && this.date.getDate() == date
        },
        deselectDate() {
            this.closeCalendar()
        }
    }
}
</script>

<style scoped>
.calendar-container {
    position: relative;
    width: 25rem;
}

.date-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1.5rem 4rem;
}
.neu {
    background-color: #222;
}
.calendar-wrap {
    position: absolute;
    top: -150%;
    background-color: var(--background-light);
    box-shadow: 0 0 15px -10px black;
    border-radius: 1.5rem;
    padding: 0.8rem;
    width: 100%;
}

.header {
    /* padding: 0 2rem; */
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 0.7rem;
}

.calendar-button {
    padding: 0.5rem !important;
    margin: 0 !important;
    width: 3rem !important;
    height: 3rem !important;
}

.chevron {
    cursor: pointer;
    font-size: 1.6rem;
}


.header-date {
    font-size: 1.1rem;
}


.days {
    display: flex;
    justify-content: space-between;
    margin-bottom: 0.5rem;
}

.day {
    text-align: center;
    width: calc(100% / 7);
}

.date-wrap {
    position: relative;
    text-align: center;
    width: calc(100% / 7);
    aspect-ratio: 1;
}

.dates {
    display: flex;
    flex-wrap: wrap;
}

.date {
    position: absolute;
    width: 75%;
    height: 75%;
    border-radius: 50%;
    background-color: var(--ui-main);
    /* box-shadow: 1.8px 1.8px 7px #BCBCBC, -1.8px -1.8px 7px #FFFFFF; */
}

/* .date:hover {
    background-color: var(--ui-main-hover);
} */

.date>span {
    font-weight: bold
}

.curr-date {
    border: solid 2px;
}

.picked-date {
    box-shadow: inset 1.8px 1.8px 3px #C6C6C6, inset -1.8px -1.8px 3px #FAFAFA;
}
</style>
