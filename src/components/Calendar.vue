<template>
  <div class="calendar-container">
    <div class="date-container">
      <vue-button class="calendar-button" @click="prevDay">
        <chevron-ico class="no-select" />
      </vue-button>

      <span class="bold date-label">{{ pickedDate }}</span>

      <vue-button class="calendar-button" @click="nextDay">
        <chevron-ico :rotationDegree=180 />
      </vue-button>

      <vue-button class="calendar-button flex-center" @click="openCalendar">
        <calendar-ico />
      </vue-button>
    </div>
    <transition name="fade">
      <dialog-window v-model:show="calendarVisible">
        <div class="calendar-wrap">
          <div class="calendar no-select card">
            <div class="calendar-header">
              <vue-button class="calendar-button" @click="gotoPresentDate">
                <home-ico class="home-ico" />
              </vue-button>

              <vue-button class="calendar-button" @click="prevMonth">
                <chevron-ico />
              </vue-button>

              <span class="calendar-header-date bold">{{ monthName }} {{ currYear }}</span>

              <vue-button class="calendar-button" @click="nextMonth">
                <chevron-ico :rotationDegree=180 />
              </vue-button>

              <vue-button class="calendar-button" @click="closeCalendar">
                <x-ico/>
              </vue-button>
            </div>

            <div class="days">
              <span v-for="(day, index) in days" :key="index" class="day bold">{{ day }}</span>
            </div>
            <div class="dates">
              <div class="date-wrap flex-center" v-for="(date, index) in dates" :key="index">
                <vue-button class="date flex-center" :class="{
                                        'picked': isPickedDate(currYear, currMonth, date),
                                        'disabled': !date
                                    }" @click="setDate(currYear, currMonth, date)">
                  <span class="bold">{{ date }}</span>
                </vue-button>
              </div>
            </div>
          </div>
        </div>
      </dialog-window>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'vueCalendar',
  props: {
    date: {
      type: Date,
      required: true
    }
  },
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
      currDate: null,
      calendarVisible: false
    }
  },
  computed: {
    pickedDate() {
      return `${this.date.getMonth() + 1}/${this.date.getDate()}/${this.date.getFullYear()}`
    },
    currDay() {
      return this.currDate.getDate()
    },
    currMonth() {
      return this.currDate.getMonth()
    },
    currYear() {
      return this.currDate.getFullYear()
    },
    monthName() {
      return this.months[this.currDate.getMonth()]
    },
    dates() {
      const dates = []
      const offset = this.getOffset(this.currYear, this.currMonth)
      for (let i = 1; i <= offset; i++)
        dates.push('')
      const datesAmount = new Date(this.currYear, this.currMonth + 1, 0).getDate()
      for (let i = 1; i <= datesAmount; i++)
        dates.push(i)
      const remainingDays = (offset + datesAmount) % 7
      for (let i = 0; i < (remainingDays > 0 ? (7 - remainingDays) : 0); i++)
        dates.push('')
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
      this.currDate = new Date()
      this.$emit('changeDate', this.currDate)
    },
    prevDay() {
      this.currDate = new Date(this.currYear, this.currMonth, this.currDay - 1)
      this.$emit('changeDate', this.currDate)
    },
    nextDay() {
      this.currDate = new Date(this.currYear, this.currMonth, this.currDay + 1)
      this.$emit('changeDate', this.currDate)
    },
    prevMonth() {
      this.currDate = new Date(this.currYear, this.currMonth - 1, this.currDay + 1)
    },
    nextMonth() {
      this.currDate = new Date(this.currYear, this.currMonth + 1, this.currDay + 1)
    },
    getOffset(year, month) {
      return (new Date(year, month, 1).getDay() + 6) % 7
    },
    isPickedDate(year, month, date) {
      return this.date.getFullYear() == year
          && this.date.getMonth() == month
          && this.date.getDate() == date
    },
    setDate(year, month, date) {
      this.currDate = new Date(year, month, date)
      this.$emit('changeDate', this.currDate)
      this.closeCalendar()
    }
  },
  created() {
    this.currDate = this.date
  },
  watch: {
    calendarVisible(newValue) {
      if (newValue === true)
        return
      setTimeout(() => {
        if (!this.isPickedDate(this.currYear, this.currMonth, this.currDay))
          this.currDate = new Date(this.date)
      }, 200)
    }
  }
}
</script>

<style scoped>
.calendar-container {
  position: relative;
}

.date-container {
  display: flex;
  justify-content: center;
  gap: 1.5rem;
  align-items: center;
}

.neu {
  background-color: #222;
}

.calendar-wrap {
  position: relative;
  min-width: 25rem;
  height: 430px;
}

.calendar {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  padding: 0.8rem;
}

.calendar-header {
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

.date-label {
  width: 6rem;
  text-align: center;
}


.calendar-header-date {
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
  padding: 0 !important;
  margin: 0 !important;
  width: 75% !important;
  height: 75% !important;
  border-radius: 50%;
  background-color: var(--ui-main);
  /* box-shadow: 1.8px 1.8px 7px #BCBCBC, -1.8px -1.8px 7px #FFFFFF; */
}

.date.picked {
  border: solid 2px #00000055
}

.date.disabled {
  pointer-events: none;
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